(ns cupcake.core-test
  (:require [clojure.test :refer :all]
            [cupcake.core :refer :all]))

(deftest base-cakes
  (testing "Returns the description for a bare cupcake"
    (let [c (cupcake)]
      (is (= (desc c) "🧁"))))

  (testing "Returns the description for a bare cookie"
    (let [c (cookie)]
      (is (= (desc c) "🍪")))))
