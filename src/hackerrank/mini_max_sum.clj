(ns hackerrank.mini-max-sum)

(defn read-longs []
  (map #(Long/parseLong %) (-> (read-line)
                               (clojure.string/split #"\s"))))

(let [nums (read-longs)
      partitions (partition 4 (take 20 (cycle nums)))
      sums (map #(apply + %) partitions)]
  (print (apply min sums) (apply max sums)))
