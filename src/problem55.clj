(ns euler.problem55
  (:import [java.math BigDecimal]))

(defn- reversed [n]
  (let [s (str n)]
    (BigDecimal. (clojure.string/reverse s))))

(defn- palindrom? [n]
  (= n (reversed n)))

(defn- next-number [n]
  (+ n (reversed n)))

(defn lychrel-number? [^Integer n]
  (loop [k n i 0]
    (if (>= i 50)
      true
      (if (and (> i 0) (palindrom? k)) false
        (recur (next-number k) (inc i))))))

(defn solution []
  (println (count (filter lychrel-number? (range 10 10000)))))

(time (solution))
