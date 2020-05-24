(ns app.sound)

(defn pitch-for-key [key-num]
      ;; formula from here: https://en.wikipedia.org/wiki/Piano_key_frequencies
      (* 440 (js/Math.pow 2 (/ (- key-num 49) 12))))

(defn audio-context [] (js/window.AudioContext.))

(defn connect [node context]
      (.connect context node))

(defn oscillator [context type freq]
      (println context)
      (let [osc (.createOscillator  context)]
           (set! (.-type osc) type)
           (set! (.-frequency osc) freq)
           osc)
      )