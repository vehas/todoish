(ns v2.sub)

(defn count-completed-tasks [titles]
  (count (filter :status titles)))