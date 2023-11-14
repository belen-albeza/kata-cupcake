(ns cupcake.description
  (:require [clojure.string :as str]))

(defn- toppings-desc [toppings]
  {:pre [(vector? toppings) (every? #(some? (:desc %)) toppings)]}
  (str/join " and " (map :desc toppings)))

(defn desc [cake]
  {:pre [(some? (:desc cake)) (vector? (:toppings cake))]}
  (if (empty? (:toppings cake))
    (:desc cake)
    (let [toppings (toppings-desc (:toppings cake))]
      (str (:desc cake) " with " toppings))))
