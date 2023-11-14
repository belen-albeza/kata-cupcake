(ns cupcake.price
  (:require [clojure.string :as str]))

(defn- raw-price-toppings [toppings]
  (reduce + (map :price toppings)))

(defn- raw-price [cake]
  {:pre [(number? (:price cake)) (vector? (:toppings cake))]}
  (+ (:price cake) (raw-price-toppings (:toppings cake))))

(defn price [cake]
  (let [raw (raw-price cake)]
    (str "$" (format "%.2f" raw))))
