(ns euler.problem09)

(defn- triplet? [a b c]
  (and (< a b c) (= (* c c) (+ (* a a) (* b b)))))

(defn- valid? [a b c]
  (and (triplet? a b c) (= 1000 (+ a b c))))

(defn solution []
  (let [[x y z] (first (into []
                         (for [a (range 1 1000) b (range 1 1000) c [(- 1000 a b)]
                               :when (valid? a b c)] [a b c])))]
    (println (* x y z))))

(time (solution))
