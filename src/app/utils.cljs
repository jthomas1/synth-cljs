(ns app.utils)

(defn round [value, decimals]
      ;; Rounding is a bit dodgy in javascript
      ;; http://www.jacklmoore.com/notes/rounding-in-javascript/
      (js/Number (str (js/Math.round (str value "e" decimals)) "e-" decimals)))
