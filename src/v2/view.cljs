(ns v2.view
  (:require
    [main.main-frame :as frame]
    [v2.db :as db]
    [v2.event :as event]
    [v2.sub :as sub]))

(defn check-box [uuid status]
  [:input {:type "checkbox"
           :checked status
           :on-change (event/set-check uuid)}])

(defn delete [uuid]
  [:button {:on-click (event/remove-task uuid)}
           "X"])

(defn title [m]
  [:li {:style {:color "green"
                :padding "10px"
                :padding-left "20px"
                :list-style-type "decimal"}}
   [check-box (:id m) (:status m)]
   [:span {:style
           {:min-width 200
            :text-decoration (if (:status m)
                               "line-through"
                               "none")}
           :on-click (event/set-text m)}
          (:title m)]
   [delete (:id m)]])

(defn main []
  [frame/page-view
   {:header "v1 + ratom"
    :content
            [:div
             [:div "completed tasks :" (sub/count-completed-tasks @db/titles)]
             [:form
              [:label "add list"]
              [:input {:type        "text"
                       :value       (:text @db/input)
                       :placeholder @db/input-check
                       :on-change   event/set-input}]
              [:button {:on-click (fn [e]
                                    (.preventDefault e)
                                    (event/save-text))}
               "add"]]
             [:ul
              (for [t @db/titles]
                [title (assoc t :key (:id t))])]]}])
