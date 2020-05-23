(ns app.main
  (:require
    [app.sound :refer [pitch-for-key]]
    [reagent.core :as r]
    [reagent.dom :as rdom]))

(defonce note-map {1 "A" 2 "A#" 3 "B" 4 "C" 5 "C#" 6 "D" 7 "D#" 8 "E" 9 "F" 10 "F#" 11 "G" 12 "G#"})

(defn note-for-key [key-num]
      (let [result (mod key-num 12)]
           (if (= 0 result) (note-map 12) (note-map result))))

(defn piano-key-component [key-num]
      ^{:key key-num} [:button
            {:on-click #(println (pitch-for-key key-num)) :type "button"}
            (str key-num " " (note-for-key key-num))])

(defn piano-component []
      (for [n (range 1 89)]
           (piano-key-component n)))

(defn mount-app []
      (rdom/render piano-component (js/document.getElementById "app")))

(defn main! [] (mount-app))

(defn reload! []
      (println "Code updated.") (main!))