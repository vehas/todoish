(ns v2.db
  (:require [reagent.core :as r]))

(def titles
  (r/atom
    [{:title "milk"     :id (random-uuid)}
     {:title "beer"     :id (random-uuid)}
     {:title  "gas"     :id (random-uuid)}
     {:title  "charger" :id (random-uuid)}
     {:title  "chair"   :id (random-uuid)}]))

(def input (r/atom {}))
(def input-check (r/atom nil))

(def goal
  ["show atom ability"
   "separate db, event, view, and sub"
   "test1 : add X button to delete text"
   "test2 : when click at text show alert box to edit ext"
   "test3 : add start to favourite text"])
