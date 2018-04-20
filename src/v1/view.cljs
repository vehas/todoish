(ns v1.view
  (:require
    [main.main-frame :as frame]
    [v1.db :as db]
    [util.core :as util]))

(defn title [m]
  ;(println "title")
  [:li {:style {:color "green"
                :padding "10px"
                :padding-left "20px"
                :list-style-type "decimal"}}
       (:title m)])

(defn main []
  [frame/page-view
   {:header "basic todo list with list of text"
    :goal db/goal
    :content
     [:ul
      (for [[t index] (util/+index db/titles)]
          [title (assoc t :key index)])]}])
