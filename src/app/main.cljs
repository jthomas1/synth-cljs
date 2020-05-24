(ns app.main
  (:require
    [app.sound :refer [pitch-for-key]]
    [reagent.core :as r]
    [reagent.dom :as rdom]))

(defonce audio-data (r/atom {:pitch 0 :volume 0 :waveform "sine"}))

(defn update-value [key value]
      (swap! audio-data assoc key value))

(def audio-context js/AudioContext.)

(defonce note-map {1 "A" 2 "A#" 3 "B" 4 "C" 5 "C#" 6 "D" 7 "D#" 8 "E" 9 "F" 10 "F#" 11 "G" 12 "G#"})

(defn note-for-key [key-num]
      (let [result (mod key-num 12)]
           (if (= 0 result) (note-map 12) (note-map result))))

(defn key-component [key-num]
      [:button
       {:on-click #(update-value :pitch (pitch-for-key key-num)) :type "button"}
       (str key-num " " (note-for-key key-num))])

(defn keyboard-component []
      [:section.keyboard
       (for [n (range 1 89)]
            ^{:key n} [key-component n])])

(defn volume-component [value]
      [:label "Volume: "
       [:input
        {:type  "number" :min "0" :max "100" :step "1"
         :value value :on-change #(update-value :volume (-> % .-target .-value))}]])

(defn waveform-selector-component []
           [:label "Waveform: "
              [:select {:on-change #(update-value :waveform (-> % .-target .-value))}
               [:option {:value "sine"} "Sine"]
               [:option {:value "triangle"} "Triangle"]
               [:option {:value "sawtooth"} "Sawtooth"]
               [:option {:value "square"} "Square"]]])

(defn synth-controls-component []
      [:section.controls
       [volume-component (:volume @audio-data)]
       [waveform-selector-component]])

(defn synth-component []
      [:div [synth-controls-component] [keyboard-component]])

(defn main-page-component []
      [:main
       [:h1 "Hello Synth"]
       [synth-component]])

(defn mount-app []
      (rdom/render [main-page-component] (js/document.getElementById "app")))

(defn main! [] (mount-app))

(defn reload! []
      (println "Code updated.") (main!))