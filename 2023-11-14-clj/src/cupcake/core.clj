(ns cupcake.core
  (:require [clojure.string :as str])
  (:gen-class))

(defn cupcake []
  {:desc "🧁" :toppings []})

(defn cookie []
  {:desc "🍪" :toppings []})

(defn- toppings-desc [toppings]
  {:pre [(vector? toppings) (every? #(some? (:desc %)) toppings)]}
  (str/join " and " (map :desc toppings)))

(defn desc [cake]
  (if (empty? (:toppings cake))
    (:desc cake)
    (let [toppings (toppings-desc (:toppings cake))]
      (str (:desc cake) " with " toppings))))

(defn- add-topping [cake topping]
  {:pre (vector? (:toppings cake))}
  (let [
    toppings (:toppings cake)
    next-toppings (conj toppings {:desc topping})]
    (assoc cake :toppings next-toppings)))

(defn chocolate [cake]
  (add-topping cake "🍫"))

(defn nuts [cake]
  (add-topping cake "🌰"))

(defn sugar [cake]
  (add-topping cake "🍬"))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
