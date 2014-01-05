(ns euler.problem24
  (:require [clojure.math.combinatorics :as c]
            [clojure.string :as s]))

(defn solution []
  (println (nth (sort (pmap s/join (c/permutations [0 1 2 3 4 5 6 7 8 9]))) (- 1000000 1))))

(time (solution))
