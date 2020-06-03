(ns app.sound)

(defn pitch-for-key [key-num]
      ;; formula from here: https://en.wikipedia.org/wiki/Piano_key_frequencies
      (* 440 (js/Math.pow 2 (/ (- key-num 49) 12))))

(defn audio-context [] (js/window.AudioContext.))

(defn current-time [context]
      (.-currentTime context))

(defn connect [node context]
      (.connect context node))

(defn gain [context]
      (.createGain context))

(defn oscillator [context]
     (.createOscillator context))