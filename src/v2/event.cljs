(ns v2.event
  (:require [v2.db :as db]))


(defn save-text []
  (if (empty? (:text @db/input))
      (reset! db/input-check "please input something")
      (do
        (swap!
          db/titles
          conj
          {:title (:text @db/input)
           :id    (random-uuid)})
        (reset! db/input nil))))