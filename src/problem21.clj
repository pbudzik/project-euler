(ns euler.problem21)

(defn sum-of-divisors [n]
  (loop [k 2 s (bigint 1)]
    (if (< k (Math/sqrt n))
      (if (zero? (rem n k))
        (recur (inc k) (+ s k (/ n k)))
        (recur (inc k) s))
      s)))

(def memo-sum-of-divisors (memoize sum-of-divisors))

(defn amicable? [a b]
  (println a b)
  (and (= (md a) b) (= (md b) a)))

(defn solution []
  (reduce + (for [a (range 2 10000)]
              (let [b (memo-sum-of-divisors a)]
                (if (and (not= a b) (= a (memo-sum-of-divisors b))) a 0)))))

(time (solution))


