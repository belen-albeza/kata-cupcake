(ns cupcake.description-test
  (:require [clojure.test :refer :all]
            [cupcake.core :refer :all]
            [cupcake.description :refer :all]))

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

(deftest multiple-toppings-test
  (testing "Returns the description for a cake with two toppings"
    (let [c (chocolate(nuts(cupcake)))]
      (is (= (desc c) "🧁 with 🌰 and 🍫"))))

  (testing "Returns the description for a cake with three toppings"
    (let [c (nuts (sugar(chocolate(cookie))))]
      (is (= (desc c) "🍪 with 🍫 and 🍬 and 🌰")))))