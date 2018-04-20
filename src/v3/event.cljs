(ns v3.event
  (:require
    [v3.db :as db]
    [re-frame.core :as f]))

(defn save-text []
  (if (empty? (:text @db/input))
      (reset! db/input-check "please input something")
      (do
        (f/dispatch
          [::add-todo @db/input])
        (reset! db/input nil))))


(f/reg-event-db
  ::add-todo
  (fn  [db [_ task]]
    (let [id (random-uuid)]
      (assoc-in  db
                 [:tasks id]
                 {:title (:text task)
                  :id    id
                  :create-at (js/Date)}))))

(f/reg-event-db
  ::delete
  (fn [db [_ id]]
    (update-in db [:tasks ] dissoc id)))