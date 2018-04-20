(ns main.events
  (:require
    [re-frame.core :as re-frame]
    [main.db :as db]))
(re-frame/reg-event-db
 ::initialize-db
 (fn  [_ _]
   db/init-db))

(re-frame/reg-event-db
 :routes/home
 (fn  [db _]
   (-> db
       (assoc :page :home))))

(re-frame/reg-event-db
 :routes/about
 (fn  [db _]
   (-> db
       (assoc :page :about))))

(re-frame/reg-event-db
  :routes/v
  (fn  [db [_ version]]
    (-> db
        (assoc :page (keyword (str "v" version))))))
               ;:version  version))))
(re-frame/reg-event-db
  ::user
  (fn [db [_ name]]
      (-> db
          (assoc :user name))))