(ns euler.problem14)

(defn- collatz-len [n]
  (loop [k n s []]
    (if (= 1 k) (count (conj s 1))
      (recur (if (even? k) (/ k 2) (inc (* 3 k))) (conj s k)))))

(defn- reducer [x y]
  (let [[x1 x2] x [y1 y2] y]
    (if (> x2 y2) x y)))

(defn solution []
  (let [results (pmap #(vector % (collatz-len %)) (range 2 1000000))]
    (println (first (reduce reducer results)))))

(time (solution))
