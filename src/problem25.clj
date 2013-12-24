(ns euler.problem25)

(defn solution []
  (loop [a (bigint 1) b (bigint 1) x 2]
    (let [c (+ a b)]
      (if (>= (count (str c)) 1000)
        (println (inc x))
        (recur b c (inc x))))))

(solution)





