(ns cupcake.core
  (:require [clojure.string :as str])
  (:gen-class))

(defn cupcake []
  {:desc "🧁" :toppings [] :price 1.0})

(defn cookie []
  {:desc "🍪" :toppings [] :price 2.0})

(defn- add-topping [cake topping price]
  {:pre (vector? (:toppings cake))}
  (let [
    toppings (:toppings cake)
    next-toppings (conj toppings {:desc topping :price price})]
    (assoc cake :toppings next-toppings)))

(defn chocolate [cake]
  (add-topping cake "🍫" 0.1))

(defn nuts [cake]
  (add-topping cake "🌰" 0.2))

(defn sugar [cake]
  (add-topping cake "🍬" 0.3))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
