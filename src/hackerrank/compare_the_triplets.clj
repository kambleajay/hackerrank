(ns hackerrank.compare-the-triplets)

(defn read-rating []
  "Returns ratings read from input as a list of numbers."
  (map #(Long/parseLong %) (-> (read-line)
                               (clojure.string/split #"\s"))))

(defn award-point [scores ratings]
  "Returns the updated scores after comparing ratings."
  (let [[score-1 score-2] scores
        [rating-1 rating-2] ratings]
    (cond
      (> rating-1 rating-2) [(inc score-1) score-2]
      (< rating-1 rating-2) [score-1 (inc score-2)]
      :else scores)))

(defn scores [rating-1 rating-2]
  "Returns the scores as a two element vector given two rating lists."
  (let [interleaved-scores (interleave rating-1 rating-2)
        partitioned-scores (partition 2 interleaved-scores)]
    (clojure.string/join " " (reduce award-point [0 0] partitioned-scores))))

(defn -main [& args]
  "Prints the scores calculated from given ratings."
  (let [rating-1 (read-rating)
        rating-2 (read-rating)]
    (print (scores rating-1 rating-2))))
