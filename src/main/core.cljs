(ns core
  (:require [reagent.core :as r]
            ["react-dom/client" :refer [createRoot]]))

(defonce db (r/atom {:name "World"}))

(defn app []
  (let [name (:name @db)]
    [:div
     [:h1 (str "Hello " name)]]))

(defonce root (createRoot (.getElementById js/document "app")))

(defn init []
  (.render root (r/as-element [app])))

(defn ^:dev/after-load re-render
  []
  ;; The `:dev/after-load` metadata causes this function to be called
  ;; after shadow-cljs hot-reloads code.
  ;; This function is called implicitly by its annotation.
  (init))
