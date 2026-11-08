import SwiftUI

struct CareersView: View {
    var body: some View {
        NavigationStack {
            ScrollView {
                VStack(alignment: .leading, spacing: 18) {
                    Eyebrow(text: "Careers")
                    Text("Build Your Career With Modus21")
                        .font(.title3.weight(.bold))
                        .foregroundStyle(Brand.ink)
                        .fixedSize(horizontal: false, vertical: true)

                    VStack(alignment: .leading, spacing: 8) {
                        Text(Company.cultureTitle)
                            .font(.headline)
                            .foregroundStyle(Brand.navy)
                        Text(Company.culture)
                            .font(.body)
                            .foregroundStyle(Brand.muted)
                            .fixedSize(horizontal: false, vertical: true)
                    }

                    VStack(alignment: .leading, spacing: 12) {
                        Text("Benefits")
                            .font(.headline)
                            .foregroundStyle(Brand.navy)
                        ForEach(Company.benefits, id: \.self) { benefit in
                            HStack(alignment: .top, spacing: 10) {
                                Image(systemName: "checkmark")
                                    .font(.footnote.weight(.bold))
                                    .foregroundStyle(Brand.navy)
                                    .frame(width: 22, height: 22)
                                    .background(Brand.navy.opacity(0.08), in: Circle())
                                    .accessibilityHidden(true)
                                Text(benefit)
                                    .font(.body)
                                    .foregroundStyle(Brand.ink)
                                    .fixedSize(horizontal: false, vertical: true)
                            }
                        }
                    }

                    VStack(spacing: 10) {
                        Link(destination: Company.jobs) {
                            FilledAction(title: "Open Positions")
                        }
                        Link(destination: Company.careersMail) {
                            OutlineAction(title: Company.careersEmail)
                        }
                    }
                    .padding(.top, 4)

                    Text(Company.careersPrompt)
                        .font(.footnote)
                        .foregroundStyle(Brand.muted)
                        .fixedSize(horizontal: false, vertical: true)

                    Text(Company.equalOpportunity)
                        .font(.footnote)
                        .foregroundStyle(Brand.muted)
                        .fixedSize(horizontal: false, vertical: true)
                }
                .padding(.horizontal, 20)
                .padding(.vertical, 16)
            }
            .screenBackground()
            .navigationTitle("Careers")
            .navigationBarTitleDisplayMode(.large)
        }
    }
}
