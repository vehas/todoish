(ns v3.sub
  (:require
    [re-frame.core :as f]))

(f/reg-sub
  ::tasks
  (fn [{:keys [tasks]}]
    (->> tasks
         (vals)
         (sort-by :create-at))))

;(f/reg-sub)
  ;::c)
