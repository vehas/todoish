(ns v4.event
  (:require
    [day8.re-frame.http-fx]
    [v3.db :as db]
    [re-frame.core :as f]
    [ajax.core :as ajax]))

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

(f/reg-event-fx
  ::http-get-user
  (fn [_ _]
    {:http-xhrio {:method          :get
                  :uri             "https://randomuser.me/api/"
                  :params          nil
                  :timeout         5000
                  :format          (ajax/json-request-format)
                  :response-format (ajax/json-response-format {:keywords? true})
                  :on-success      [::get-user]
                  :on-failure      [::bad-result]}}))

(f/reg-event-db
  ::get-user
  (fn [db [_ json]]
    (assoc db :main-user json)))

(f/reg-event-db
  ::bad-result
  (fn [db [_ error]]
    (assoc db :error error)))
