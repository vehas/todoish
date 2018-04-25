(ns main.db)

(defonce init-db
         {:page :home
          :tasks {}
          :users ["bobby" "alan" "ken" "lily"]
          :user  "bobby"})

(comment
  {:id1 {:title "a"
         :id :id1}
   :id2 {:title ""}})