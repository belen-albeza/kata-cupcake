(ns cupcake.core
  (:gen-class))

(defn cupcake []
  {:desc "🧁"})

(defn cookie []
  {:desc "🍪"})

(defn desc [cake]
  (:desc cake))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
