(ns euler.problem22)

(defn- char-score [c] (- (int c) 64))

(defn- word-score [s i] (* i (reduce + (map char-score s))))

(defn solution []
  (let [content (slurp "src/names.txt")
        names (sort (map #(.replaceAll % "\"" "") (vec (.split content ","))))
        vals (for [i (range 0 (count names))]
               (word-score (nth names i) (inc i)))]
    (println (reduce + vals))))

(time (solution))


