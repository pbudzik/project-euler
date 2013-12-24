(ns euler.problem40)

(defn fraction-digits []
  (loop [r {:d0 1} n 1 k 1]
    (if (= 7 (count r))
      r
      (let [v (map #(read-string (str %)) (str n))
            nr (into {}
                 (for [i (range 0 (dec (count v)))]
                   (let [d (nth v i)]
                     (condp = (+ k i)
                       10 [:d1 d]
                       100 [:d2 d]
                       1000 [:d3 d]
                       10000 [:d4 d]
                       100000 [:d5 d]
                       1000000 [:d6 d]
                       nil)
                     )))]
        (recur (merge r nr) (inc n) (+ k (count v)))))))

(defn solution []
  (println (apply * (vals (fraction-digits)))))

(time (solution))


