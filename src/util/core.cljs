(ns util.core)


(defn +index [list]
  (map #(-> [%1 %2])
       list
       (range)))