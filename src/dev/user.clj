(ns dev.user
  (:require [shadow.cljs.devtools.api :as dapi]))

(defn cljs-repl []
  (dapi/nrepl-select :browser))

(comment
  (cljs-repl))