(ns hackerrank.birthday-cake-candles)

(defn read-longs []
  (map #(Long/parseLong %) (-> (read-line)
                               (clojure.string/split #"\s"))))

(let [n (Long/parseLong (read-line))
      nums (read-longs)
      max-num (apply max nums)]
  (print (count (filter #(= % max-num) nums))))
