(ns euler.problem20)

(defn- factorial [n]
  (loop [k n sum (bigint 1)]
    (if (zero? k) sum
      (recur (- k 1) (* sum k)))))

(defn solution []
  (println (reduce + (map #(read-string (str %)) (str (factorial 100))))))

(solution)




