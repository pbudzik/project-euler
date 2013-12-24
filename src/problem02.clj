(ns euler.problem02)

(defn solution []
  (loop [a 1 b 1 sum 0 x 3]
    (let [c (+ a b)]
      (if (>= c 4000000)
        (println sum)
        (recur b c (if (even? c) (+ sum c) sum) (inc x))))))

(solution)


