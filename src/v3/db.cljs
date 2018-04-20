(ns v3.db
  (:require [reagent.core :as r]))

;(def titles
;  (r/atom
;    [{:title "milk"     :id (random-uuid)}
;     {:title "beer"     :id (random-uuid)}
;     {:title  "gas"     :id (random-uuid)}
;     {:title  "charger" :id (random-uuid)}
;     {:title  "chair"   :id (random-)}))

(def input (r/atom {}))
(def input-check (r/atom nil))

(def goal
  ["show how re-frame work by adding event, sub, and db"
   "test 1: edit current data"
   "test 2: add button to sort data by another property (length/lexical)"])

