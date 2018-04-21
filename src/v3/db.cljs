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
   "test 2: add button to sort data by another property (length/lexical)"
   "test 3: add hide/show button to manipulate task component"
   "test 4: add user who make task/show it in detail of task component"
   "tast 5: add user who edit it"
   "test 6: add tags in task component"
   "test 7: add search bar and search by tags"
   "test 8: add board property"
   "test 9: change ui to kanban board style"

   "learning part 4 option"
   "option 1 > datascript/datalog : clojure and lisp in general
     are made for and really good at list manipulation but real world data are in much more complex form
     like tree, graph or regtangle shape data with relational (RDBMS), can we have better tool for query/manipulate this,
     introduction to datascript/datalog, in-memory database design for query relation and graph data"
   ["test for option 1"
      ["add assign to (who) in task list"]
      ["hiligth only task that person are assgin to"]
      ["recommand user to assign by looking at history of who assign who,"]
      ["use search bar for search user, tags, board and title (can be combined)
        by user start with @
           tags start with #
           board start with *
           and title just use string"]]
   "option 2 > call REST api : make GET/POST async request and speak to server, declarative"
   ["test for option 2"
     ["make rest for https://cljs-server.firebaseio.com/users.json
                 and https://cljs-server.firebaseio.com/tasks.json
      read more about rest api format here : https://firebase.google.com/docs/reference/rest/database/"]]
   "option 3 > testing : testing declarative system with pure function  component : no more mocking"
   ["test for option 3"
    ["run karma test for unit testing app,
                           UI testing,
                      and e2e testing"]]
   "option 4 > use better code structure"
   ["test for option 4"
    ["prerequisinst growth app codebase until you can not handle it,
      then pray"]
    "option 5 > use npm package"
    ["test for option 5"
     ["try to use left-pad then code-mirror then https://github.com/reactjs/react-modal"]]]])

