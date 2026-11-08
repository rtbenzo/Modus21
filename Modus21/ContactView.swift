import MapKit
import SwiftUI

struct ContactView: View {
    @State private var camera: MapCameraPosition = .region(
        MKCoordinateRegion(
            center: Company.office,
            span: MKCoordinateSpan(latitudeDelta: 0.03, longitudeDelta: 0.03)
        )
    )

    var body: some View {
        NavigationStack {
            ScrollView {
                VStack(alignment: .leading, spacing: 16) {
                    Eyebrow(text: "Contact Us")
                    Text("Let's Discuss Your Mission")
                        .font(.title3.weight(.bold))
                        .foregroundStyle(Brand.ink)
                    Text(Company.contactPrompt)
                        .font(.body)
                        .foregroundStyle(Brand.muted)
                        .fixedSize(horizontal: false, vertical: true)

                    Map(position: $camera) {
                        Marker(Company.name, coordinate: Company.office)
                            .tint(Brand.navy)
                    }
                    .mapStyle(.standard(elevation: .flat))
                    .frame(height: 200)
                    .clipShape(RoundedRectangle(cornerRadius: 16, style: .continuous))
                    .accessibilityLabel("Map showing the Modus21 office in North Charleston, South Carolina")

                    BrandCard {
                        VStack(alignment: .leading, spacing: 4) {
                            Text("Location")
                                .font(.caption.weight(.semibold))
                                .tracking(0.6)
                                .foregroundStyle(Brand.navy)
                            Text(Company.name)
                                .font(.headline)
                                .foregroundStyle(Brand.ink)
                            Text(Company.street)
                            Text(Company.suite)
                            Text(Company.cityLine)
                        }
                        .font(.body)
                        .foregroundStyle(Brand.ink)
                    }

                    VStack(spacing: 12) {
                        Link(destination: Company.linkedIn) {
                            BrandCard {
                                ActionRow(
                                    title: "LinkedIn",
                                    subtitle: Company.linkedInNote,
                                    systemImage: "link"
                                )
                            }
                        }
                        Link(destination: Company.phoneURL) {
                            BrandCard {
                                ActionRow(
                                    title: "Call",
                                    subtitle: Company.phoneDisplay,
                                    systemImage: "phone"
                                )
                            }
                        }
                        Link(destination: Company.careersMail) {
                            BrandCard {
                                ActionRow(
                                    title: "Email",
                                    subtitle: Company.careersEmail,
                                    systemImage: "envelope"
                                )
                            }
                        }
                        Link(destination: Company.mapsURL) {
                            BrandCard {
                                ActionRow(
                                    title: "Directions",
                                    subtitle: "Open the North Charleston office in Maps",
                                    systemImage: "map"
                                )
                            }
                        }
                        Link(destination: Company.website) {
                            BrandCard {
                                ActionRow(
                                    title: "Website",
                                    subtitle: "modus21.com",
                                    systemImage: "safari"
                                )
                            }
                        }
                    }

                    VStack(spacing: 0) {
                        NavigationLink {
                            PrivacyNoticeView()
                        } label: {
                            legalRow("Privacy Notice")
                        }
                        Divider().overlay(Brand.line)
                        NavigationLink {
                            AccessibilityStatementView()
                        } label: {
                            legalRow("Accessibility Statement")
                        }
                    }
                    .buttonStyle(.plain)
                    .background(Color.white, in: RoundedRectangle(cornerRadius: 16, style: .continuous))
                    .overlay {
                        RoundedRectangle(cornerRadius: 16, style: .continuous)
                            .stroke(Brand.line, lineWidth: 1)
                    }

                    Text(Company.footer)
                        .font(.footnote)
                        .foregroundStyle(Brand.muted)
                        .fixedSize(horizontal: false, vertical: true)
                }
                .padding(.horizontal, 20)
                .padding(.vertical, 16)
            }
            .screenBackground()
            .navigationTitle("Contact")
            .navigationBarTitleDisplayMode(.large)
        }
    }

    private func legalRow(_ title: String) -> some View {
        HStack {
            Text(title)
                .font(.body.weight(.semibold))
                .foregroundStyle(Brand.ink)
            Spacer()
            Image(systemName: "chevron.right")
                .font(.footnote.weight(.semibold))
                .foregroundStyle(Brand.muted)
        }
        .padding(.horizontal, 18)
        .padding(.vertical, 16)
        .contentShape(Rectangle())
    }
}
