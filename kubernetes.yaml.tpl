# Copyright 2018 Google LLC
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#     https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

apiVersion: apps/v1
kind: Deployment
metadata:
  name: billing-svc
  labels:
    app: billing-svc
spec:
  replicas: 1
  selector:
    matchLabels:
      app: billing-svc
  template:
    metadata:
      labels:
        app: billing-svc
    spec:
      containers:
      - name: billing-svc
        image: gcr.io/GOOGLE_CLOUD_PROJECT/billing-svc:COMMIT_SHA
        ports:
        - containerPort: 8181
---
kind: Service
apiVersion: v1
metadata:
  name: billing-svc
spec:
  selector:
    app: billing-svc
  ports:
  - protocol: TCP
    port: 8181
    targetPort: 8181
  type: LoadBalancer