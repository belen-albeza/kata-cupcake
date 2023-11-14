(ns cupcake.price-test
  (:require [clojure.test :refer :all]
            [cupcake.core :refer :all]
            [cupcake.price :refer :all]))

(deftest base-cakes-test
  (testing "Returns the price for a bare cupcake"
    (let [c (cupcake)]
      (is (= (price c) "$1.00"))))

  (testing "Returns the price for a bare cookie"
    (let [c (cookie)]
      (is (= (price c) "$2.00")))))

(deftest single-topping-test
  (testing "Returns the price for a cake with chocolate"
    (let [c (chocolate(cookie))]
      (is (= (price c) "$2.10"))))

  (testing "Returns the price for a cake with nuts"
    (let [c (nuts(cupcake))]
      (is (= (price c) "$1.20"))))

  (testing "Returns the price for a cake with sugar"
    (let [c (sugar(cupcake))]
      (is (= (price c) "$1.30")))))

(deftest multiple-toppings-test
  (testing "Returns the price for a cake with two toppings"
    (let [c (chocolate(nuts(cupcake)))]
      (is (= (price c) "$1.30"))))

  (testing "Returns the price for a cake with three toppings"
    (let [c (nuts (sugar(chocolate(cookie))))]
      (is (= (price c) "$2.60")))))
