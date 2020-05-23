(ns app.sound-test
  (:require [cljs.test :refer-macros [deftest is]]
            [app.sound :refer [pitch-for-key]]
            [app.utils :refer [round]]))

(deftest pitch-for-key-test
         ;; Reference for expectation values https://en.wikipedia.org/wiki/Piano_key_frequencies

         ;; check all the keys for A - nice round numbers
         (is (= (pitch-for-key 85) 3520))
         (is (= (pitch-for-key 73) 1760))
         (is (= (pitch-for-key 61) 880))
         (is (= (pitch-for-key 49) 440))
         (is (= (pitch-for-key 37) 220))
         (is (= (pitch-for-key 25) 110))
         (is (= (pitch-for-key 13) 55))
         (is (= (pitch-for-key 1) 27.5))

         ;; Middle C
         (is (= (round (pitch-for-key 40) 4) 261.6256))
)