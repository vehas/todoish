(ns v3.view
  (:require
    [re-frame.core :as f]
    [main.main-frame :as frame]
    ;[v3.db :as db]
    [main.subs :as main-sub]
    [main.events :as main-event]
    [v3.event :as event]
    [v3.db :as db]
    [v3.sub :as sub]
    [util.core :as util]))
(defn check-box [id checked]
  [:input {:type "checkbox"
           :check checked
           :on-click #(f/dispatch [::event/completed id])}])
(defn title [m]
  [:li {:style {:color "green"
                :padding "10px"
                :padding-left "20px"
                :list-style-type "decimal"}}
   [check-box (:id m) (f/subscribe [])]

   [:span {:style {:min-width "300px"}}
          (:title m)]
   [:button {:on-click #(f/dispatch [::event/delete (:id m)])}
            "X"]])

(defn user []
 (fn []
  (let [active-user @(f/subscribe [::main-sub/active-user])]
   [:div.user-row
     [:span " user :"
      (for [[user-name key] (util/+index @(f/subscribe [::main-sub/users]))]
        ;(do
        ;  ;(println "active : " active-user user-name)
          [:span.user {:key key
                       :on-click #(f/dispatch [::main-event/user user-name])
                       :class (when (= active-user user-name)
                                    ["active"])}
                      user-name])]])))

(defn main []
  [frame/page-view
   {:header "v1 + ratom"
    :goal db/goal
    :content
      [:div
       [user]
       [:div.app
             [:form
              [:label "add list"]
              [:input {:type        "text"
                       :value       (:text @db/input)
                       :placeholder @db/input-check
                       :on-change   #(swap! db/input assoc :text (-> % .-target .-value))}]
              [:button {:on-click (fn [e]
                                    (.preventDefault e)
                                    (event/save-text))}
               "add"]]
             [:ul
              (for [t @(f/subscribe [::sub/tasks])]
                [title (assoc t :key (:id t))])]]]}])
