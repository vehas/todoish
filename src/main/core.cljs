(ns main.core
  (:require [reagent.core :as reagent]
            [re-frame.core :as re-frame]
            [main.events :as events]
            [main.subs :as subs]
            [main.views :as views]
            [main.routes :as routes]))

(defn mount-root []
  (re-frame/clear-subscription-cache!)
  (reagent/render [views/app-root]
                  (.getElementById js/document "app")))

(defn ^:export init []
  (re-frame/dispatch-sync [::events/initialize-db])
  (routes/app-routes re-frame/dispatch)
  (mount-root))
