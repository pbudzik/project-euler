(ns euler.problem25
  (:import [java.math BigDecimal]))

(defn solution []
  (loop [a (BigDecimal. 1) b (BigDecimal. 1) x 2]
    (let [c (+ a b)]
      (if (>= (count (str c)) 1000)
        (println (inc x))
        (recur b c (inc x))))))

(time (solution))





