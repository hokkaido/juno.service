(ns juno.service
  (:require 
    [juno.resource :as resource]
    [plumbing.graph :as graph :include-macros true]))

(defn start-service [graph params]
  ((graph/eager-compile (resource/resource-transform graph)) params))

(defn shutdown-service [m]
  (doseq [f @(:shutdown-hooks m)]
    (f)))

