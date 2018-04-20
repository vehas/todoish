(ns main.subs
  (:require [re-frame.core :as re-frame]))

(re-frame/reg-sub
 ::app-view
 (fn [{:keys [page]}]
   page))

(re-frame/reg-sub
  ::version
  (fn [{:keys [version]}]
    version))

(re-frame/reg-sub
  ::users
  (fn [{:keys [users]}]
      users))

(re-frame/reg-sub
  ::active-user
  (fn [{:keys [user]}]
      user))