(ns cupcake.core-test
  (:require [clojure.test :refer :all]
            [cupcake.core :refer :all]))

(deftest base-cakes-test
  (testing "Returns the description for a bare cupcake"
    (let [c (cupcake)]
      (is (= (desc c) "🧁"))))

  (testing "Returns the description for a bare cookie"
    (let [c (cookie)]
      (is (= (desc c) "🍪")))))

(deftest single-topping-test
  (testing "Returns the description for a cake with chocolate"
    (let [c (chocolate(cookie))]
      (is (= (desc c) "🍪 with 🍫"))))

  (testing "Returns the description for a cake with nuts"
    (let [c (nuts(cupcake))]
      (is (= (desc c) "🧁 with 🌰"))))

  (testing "Returns the description for a cake with sugar"
    (let [c (sugar(cupcake))]
      (is (= (desc c) "🧁 with 🍬")))))