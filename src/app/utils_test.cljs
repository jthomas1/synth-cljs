(ns app.utils-test
  (:require [cljs.test :refer-macros [deftest is]]
            [app.utils :refer [round]]))

(deftest round-test
         (is (= (round 1.005 2) 1.01)))


