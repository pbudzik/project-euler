(ns euler.problem06)

(defn diff [n]
  (let [numbers (range 1 (inc n))
        sum-of-squares (reduce + (map #(* % %) numbers))
        sum (reduce + numbers)]
    (- (* sum sum) sum-of-squares)))

(defn solution []
  (println (diff 100)))

(solution)





