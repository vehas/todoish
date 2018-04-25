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

(defn check [uuid]
  (fn [item]
    (if (= uuid (:id item))
      (update-in item [:status] not)
      item)))

(defn remove-by-id [uuid]
  (fn [item]
    (= uuid (:id item))))

(defn change-text [uuid text]
  (fn [item]
    (if (= uuid (:id item))
      (assoc item :title text)
      item)))

(defn set-check [uuid]
 (fn []
  (swap! db/titles
         #(map (check uuid)
               %))))

(defn remove-task [uuid]
 (fn []
  (swap! db/titles
         #(remove (remove-by-id uuid)
                  %))))
(defn set-text [m]
 (fn []
  (let [text (js/prompt)]
   (swap! db/titles
          (fn  [title]
            (map (change-text (:id m) text)
                 title))))))

(def set-input
  #(swap! db/input
          assoc
          :text
          (-> % .-target .-value)))