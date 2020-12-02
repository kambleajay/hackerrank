(ns hackerrank.plus-minus)

(defn read-longs []
  (map #(Long/parseLong %) (-> (read-line)
                               (clojure.string/split #"\s"))))

(defn fraction [slice-of-nums nums]
  (format "%.6f" (double (/ (count slice-of-nums) (count nums)))))

(let [n (Long/parseLong (read-line))
      nums (read-longs)
      positives (filter #(> % 0) nums)
      zeros (filter zero? nums)
      negatives (filter #(< % 0) nums)]
  (println (fraction positives nums))
  (println (fraction negatives nums))
  (println (fraction zeros nums)))
